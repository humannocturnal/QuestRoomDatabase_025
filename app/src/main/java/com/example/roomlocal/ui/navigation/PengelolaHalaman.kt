package com.example.praktikum7.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan10.ui.view.mahasiswa.HomeMhsView
import com.example.praktikum7.ui.view.mahasiswa.DestinasiInsert
import com.example.praktikum7.ui.view.mahasiswa.DetailMhsView
import com.example.praktikum7.ui.view.mahasiswa.InsertMhsView
import com.example.praktikum7.ui.view.mahasiswa.UpdateMhsView
import com.example.roomlocal.ui.navigation.AlamatNavigasi

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    it: Any
) {
    NavHost(navController = navController, startDestination = AlamatNavigasi.DestinasiHome.route) {
        composable(
            route = AlamatNavigasi.DestinasiHome.route
        ) {
            HomeMhsView(
                onDetailClick = { nim ->
                    navController.navigate("${AlamatNavigasi.DestinasiDetail.route}/$nim")
                    println("PengelolaHalaman: nim = $nim")
                },
                onAddMhs = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier
            )
        }


        composable(
            route = DestinasiInsert.route
        ) {
            InsertMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }

        composable(
            AlamatNavigasi.DestinasiDetail.routeWithArgs,
            arguments = listOf(
                navArgument(AlamatNavigasi.DestinasiDetail.NIM) {
                    type = NavType.StringType
                }
            )
        ) {
            val nim = it.arguments?.getString(AlamatNavigasi.DestinasiDetail.NIM)
            nim?.let { nim ->
                DetailMhsView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${AlamatNavigasi.DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(
            AlamatNavigasi.DestinasiUpdate.routeWithArgs,
            arguments = listOf(
                navArgument(AlamatNavigasi.DestinasiUpdate.NIM) {
                    type = NavType.StringType
                }
            )
        ) {
            UpdateMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
    }
}
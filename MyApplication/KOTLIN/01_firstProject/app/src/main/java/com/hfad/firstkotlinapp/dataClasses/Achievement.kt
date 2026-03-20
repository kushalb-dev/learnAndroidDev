package com.hfad.firstkotlinapp.dataClasses

import com.hfad.firstkotlinapp.R

data class Achievement (var captionImg: Int, var achievementTitle: String, var achievementDate: String) {

    companion object {
        val sampleListAchievements = arrayListOf(
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 1", "Date 1"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 2", "Date 2"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 3", "Date 3"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 4", "Date 4"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 5", "Date 5"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 6", "Date 6"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 7", "Date 7"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 8", "Date 8"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 9", "Date 9"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 10", "Date 10"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 11", "Date 11"),
            Achievement(R.drawable.ic_launcher_foreground, "Achievement 12", "Date 12")
        )
    }

}
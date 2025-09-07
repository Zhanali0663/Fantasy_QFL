data class FootballerData(
    val name: String,
    val img: Int,
    val position: String, // GK, DEF, MID, ATT
    val attack: Int,      // 0-100
    val defense: Int,     // 0-100
    val price: Int        // в тенге


)

private fun insertFootballers(db: SQLiteDatabase) {
    val footballers = listOf(
        // Вратари
        FootballerData("Remove", R.drawable._348811, "GK", 20, 20, 0),
        FootballerData("СЕЙСЕН Мұхамеджан", R.drawable.seisen, "GK", 45, 80, 1200000),
        FootballerData("ЧОНДРИЧ Йосип", R.drawable.chondrich, "GK", 50, 85, 1500000),
        FootballerData("ЗАРУЦКИЙ Александр", R.drawable.zaritski, "GK", 40, 75, 800000),
        FootballerData("АНАРБЕКОВ Темірлан", R.drawable.anarbek, "GK", 35, 70, 600000),
        FootballerData("ШАЙЗАДА Бекхан", R.drawable.shaizada, "GK", 40, 72, 700000),

        // Защитники
        FootballerData("БАРТОЛЕЦ Карло", R.drawable.bartole, "DEF", 35, 85, 2500000),
        FootballerData("БЫСТРОВ Марат", R.drawable.bistr, "DEF", 40, 80, 1800000),
        FootballerData("ВОРОГОВСКИЙ Ян", R.drawable.voro, "DEF", 30, 82, 1600000),
        FootballerData("БЕЙСЕБЕКОВ Абзал", R.drawable.abzal, "DEF", 25, 75, 1200000),
        FootballerData("ШОМКО Дмитрий", R.drawable.shomko, "DEF", 35, 78, 1400000),
        FootballerData("МАРОЧКИН Александр", R.drawable.maro, "DEF", 40, 88, 3200000),
        FootballerData("МАРТЫНОВИЧ Александр", R.drawable.martin, "DEF", 30, 80, 1700000),
        FootballerData("КИКИ Габи Жуниор", R.drawable.kiki, "DEF", 45, 90, 9000000),
        FootballerData("АНТИЧ Никола", R.drawable.antich, "DEF", 50, 85, 2800000),
        FootballerData("ЭБОНГ Макс", R.drawable.ebong, "DEF", 35, 82, 1900000),
        FootballerData("ТАГЫБЕРГЕН Асхат", R.drawable.ashat, "DEF", 30, 76, 1300000),
        FootballerData("СЕЙДАХМЕТ Еркебулан", R.drawable.seidahmet, "DEF", 28, 74, 1100000),

        // Полузащитники
        FootballerData("МАТА Луиш Карлош Машаду", R.drawable.mata, "MID", 75, 60, 4500000),
        FootballerData("ҚАСАБҰЛАТ Дамир", R.drawable.kassa, "MID", 65, 70, 2200000),
        FootballerData("ТАПАЛОВ Еркін", R.drawable.tapal, "MID", 60, 65, 1800000),
        FootballerData("ЕРЛАНОВ Темірлан", R.drawable.erlan, "MID", 70, 55, 2000000),
        FootballerData("ҚАСЫМ Әлібек", R.drawable.kasim, "MID", 55, 60, 1500000),
        FootballerData("МАЛЫЙ Сергей", R.drawable.mal, "MID", 65, 70, 2100000),
        FootballerData("АСТАНОВ Сұлтанбек", R.drawable.astanov, "MID", 50, 65, 1400000),
        FootballerData("Усман Камара", R.drawable.camara, "MID", 80, 50, 3500000),
        FootballerData("Марин Томасов", R.drawable.tomasov, "MID", 70, 60, 2800000),
        FootballerData("Дастан Сатбаев", R.drawable.satba, "MID", 55, 70, 1600000),
        FootballerData("ЧЕСНОКОВ Ислам", R.drawable.chesnok, "MID", 60, 68, 1700000),
        FootballerData("ЭЛЬ МЕССАУДИ Ахмед", R.drawable.elmessa, "MID", 75, 55, 3200000),
        FootballerData("ЗАРИЯ Гиорги", R.drawable.zaria, "MID", 85, 45, 4200000),
        FootballerData("ГРИПШИ Назми", R.drawable.gripshi, "MID", 70, 50, 2500000),

        // Нападающие
        FootballerData("Чинеду Чарльз Джеффри", R.drawable.chinedu, "ATT", 90, 30, 5500000),
        FootballerData("МАСЕДО Эвертон", R.drawable.everton, "ATT", 88, 35, 5200000),
        FootballerData("ИМНАДЗЕ Лука", R.drawable.imnadze, "ATT", 80, 40, 3800000)
    )

    footballers.forEach { footballer ->
        val values = ContentValues().apply {
            put("name", footballer.name)
            put("img", footballer.img)
            put("position", footballer.position)
            put("attack", footballer.attack)
            put("defense", footballer.defense)
            put("price", footballer.price)
        }
        db.insert("footballers", null, values)
    }
}


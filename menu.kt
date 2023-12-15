package com.example.myapplication.sem2


open class MenuItem(
    open val name: String,
    open val price: Int,
    open val description: String
) {
    open fun displayInfo() {
        println("음식 이름: $name")
        println("가격: $price 원")
        println("설명: $description")
    }
}

class Drink(
    name: String,
    price: Int,
    description: String
) : MenuItem(name, price, description)

class Burger(
    name: String,
    price: Int,
    description: String
) : MenuItem(name, price, description)

class Menu {
    val menuItems = listOf(
        Burger("와퍼", 8000, "불에 직접 구운 순 쇠고기 패티에 싱싱한 야채가 한가득~ 버거킹의 대표 메뉴!"),
        Burger("불고기와퍼", 8000, "불에 직접 구운 순 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!"),
        Burger("치즈와퍼", 8600, "불에 직접 구운 순 쇠고기 패티가 들어간 와퍼에 고소한 치즈까지!"),
        Burger("통새우와퍼", 8800, "불맛 가득 순쇠고기, 갈릭페퍼 통새우, 스파이시토마토소스가 더해진 프리미엄 버거!"),

        Drink("콜라", 2900, "코카-콜라로 더 짜릿하게!"),
        Drink("사이다", 2900, "나를 깨우는 상쾌함!"),
        Drink("아메리카노", 2400, "자연을 담은 버거킹 RA인증커피")
    )

    fun showMenu() {
        val maxNameLength = menuItems.maxOfOrNull { it.name.length } ?: 0

        println("[ MENU ]")
        menuItems.forEachIndexed { index, menuItem ->
            val padding = " ".repeat(maxNameLength - menuItem.name.length)
            println("${index + 1}. ${menuItem.name}$padding | 가격: ${menuItem.price} 원 | 설명: ${menuItem.description}")
        }

        println("0. 뒤로가기")
        print(" ---> ")
    }
}

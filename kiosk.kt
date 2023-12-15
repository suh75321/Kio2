package com.example.myapplication.sem2

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myapplication.BurgerMenu
import com.example.myapplication.DrinkMenu
import kotlinx.coroutines.delay
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
var now = LocalDateTime.now()


suspend fun main() {
    println("========================================")
    println("   버거킹에 오신걸 환영합니다!  ")
    println("========================================")

    val burgerMenu = BurgerMenu()
    val drinkMenu = DrinkMenu()

    var money = 15000

    while (true) {
        try {
            println("현재 잔액: $money 원")

            println("메뉴를 선택하세요:")
            println("1. 버거")
            println("2. 음료")

            println("0. 종료")
            print(" ---> ")

            val input = readLine()!!.toInt()

            when (input) {
                1 -> {
                    burgerMenu.showMenu()

                    val burgerInput = readLine()!!.toInt()

                    when (burgerInput) {
                        0 -> {
                        }
                        in 1..burgerMenu.menuItems.size -> {
                            val selectedBurger = burgerMenu.menuItems[burgerInput - 1]
                            selectedBurger.displayInfo()

                            val totalOrderPrice = selectedBurger.price

                            if (money >= totalOrderPrice) {
                                money -= totalOrderPrice
                                println("주문이 완료되었습니다. 남은 잔액: $money 원")
                            } else {
                                println("현재 잔액은 ${money}로 ${totalOrderPrice-money}원이 부족해서 주문할 수 없습니다 .")
                            }

                            println("주문을 처리하는 중...")
                            delay(3000)
                            println("3초가 지났습니다. 다른 작업을 수행합니다.")
                        }
                        else -> {
                            println("올바른 번호를 입력하세요.")
                        }
                    }
                }
                2 -> {
                    drinkMenu.showMenu()

                    val drinkInput = readLine()!!.toInt()

                    when (drinkInput) {
                        0 -> {
                        }
                        in 1..drinkMenu.menuItems.size -> {
                            val selectedDrink = drinkMenu.menuItems[drinkInput - 1]
                            selectedDrink.displayInfo()

                            val totalOrderPrice = selectedDrink.price

                            if (money >= totalOrderPrice) {
                                money -= totalOrderPrice
                                println("주문이 완료되었습니다. 남은 잔액: $money 원")
                            } else {
                                println("현재 잔액은 ${money}로 ${totalOrderPrice-money}원이 부족해서 주문할 수 없습니다 .")
                            }

                            println("주문을 처리하는 중...")
                            delay(3000)
                            println("3초가 지났습니다. 다른 작업을 수행합니다.")
                        }
                        else -> {
                            println("올바른 번호를 입력하세요.")
                        }
                    }
                }

                0 -> {
                    println("프로그램을 종료합니다.")
                    delay(3000)
                    println("3초가 지났습니다. 다른 작업을 수행합니다.")
                    return
                }

                // ...
            }
        } catch (e: NumberFormatException) {
            println("올바른 숫자를 입력하세요.")
        }
    }
}
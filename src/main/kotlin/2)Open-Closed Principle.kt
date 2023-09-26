class `2)Open-Closed Principle` {
    /*

    Оригинальная формулировка:
    A module should be responsible to one, and only one, actor.


    Опредление:
    Программные сущности должны быть открыты для расширения, ноа закрыты для изменения

    Существующий код протестирован и с ним проблем нет, изменения могут повлечь отказ работы всего модуля.
    Для этого его нужно расширять, а не изменять.

    Продумывая схему сущностей заранее продумывайте как вы будете добавлять новый функционал, с помощью расширения,
    а не изменения существующего кода


    Так же можно например можно создать новую сущность которая содержит и старую, но вдобавок и новую логику.


    Преимущество:
    1) Нет необходимости в регрессионном тестировании
    2) Меньше вероятность ошибок
    3)
     */

}


///////////////////Пример 1
//Мы при создании нового оружия мы добавляем новый класс, вместо того чтобы добавлять логику в класс Weapon

open class Weapon(
    val damage:Int,
    val range:Int,
){
    //Если мы хотим иметь несколько типов оружия, лучше вынести отсюда этот метод в интерфейс
    //fun attack(){
        //println("Sword attack dealt $damage damage")
    //}
    open fun attack(){}
}

class Character(
    var name:String,
    var weapon: Weapon

){
    fun changeWeapon(newWeapon:Weapon){
        weapon=newWeapon
    }

    fun attack(){
        println("Sword attack dealt ${weapon.damage} damage")
        }
    }




//Создаем разные классы, "Расширяя" класс Weapon, а не добавляя в него логику
class Sword(damage: Int,range: Int): Weapon(damage, range) {
    override fun attack(){
        println("Sword attack dealt $damage damage")
    }

}

class Crossbow(damage: Int,range: Int): Weapon(damage, range) {
    override fun attack(){
        println("Crossbow attack dealt $damage damage")
    }
}

//Старый пример как создать меч если бы вся логика была в Weapon
//val sword = Weapon("Sword", 15, 1)

//Новый пример как создать меч с помощью нового класса Sword
val sword = Sword(15,1)
val character = Character("Warrior", sword)

val crossbow = Crossbow(5,20)
//Код прописываемый в main
//character.attack()
//character.changeWeapon(crossbow)
//character.attack()

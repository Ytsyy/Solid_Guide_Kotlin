class `1) Single Responsibility` {
    /*

    Оригинальная формулировка
    A module should be responsible to one, and only one, actor.

        Опредление:
        1 класс должен решать 1 задачу
        (Единственная зона ответственности / Декомпозиция )


        Преимущества:
        1) Повышение читабельности через декомпозицию на модули
        2) Внесения изменений становятся проще
        3) Избавление от антипаттерна GodObject
        4) Класс инкапсулирует решение одной задачи
         */



}

/////////////////////Пример 1
//Изначальный класс, содержащий слишком много методов
class Class(
    var field1:Int,
    var field2:Int
){
    fun getField1(){}
    fun getField2(){}

    fun save(){}

    fun send(){}
    fun getHTTP(){}

    fun print(){}

    fun log(){}
}


//Выносим логику работы с репозиторием

class Repository(){
    fun save(){}

    fun remove(){}

    fun get(){}
}

//Выносим логику работы c HTTP запросами
class HTTPSender(){
    fun sendHTTP(){}

    fun getHTTP(){}
}
//Выносим логирование
class Logger(){
    fun logToExcel(){}
    fun logToTXT(){}
}
//Выносим печать
class Printer(){
    fun printToPDF(){}
    fun printToDoc(){}
}
//В итоге методы у которых четко обозначенные зоны ответственности


////////////////////////////Пример 2
//Класс User в котором слишком много ответственности

class User(
    _id: Int,
    _usermane: String,
    _password:String
) {
    val id: Int = _id
    val username:String = _usermane
    val password: String = _password


    fun saveToDataBase(){
        //save in DataBase
    }

    fun log(){
        log()
    }
    fun send(){
        //
    }

}

//Что стоит убрать в отдельные методы:

class UserRepository{
    fun save(){}
}

class UserLogger(){
    fun log(){}
}
class UserController(){
    fun send(){}
}
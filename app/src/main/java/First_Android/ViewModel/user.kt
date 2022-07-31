package First_Android.ViewModel

import java.io.Serializable

class User(var age: Int, var name: String) : Serializable{
   override fun toString() = "User{age=${age}, name=${name}}"
}
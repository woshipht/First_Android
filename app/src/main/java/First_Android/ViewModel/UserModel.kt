package First_Android.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserModel: ViewModel() {
    val mUserLiveData : MutableLiveData<User> = MutableLiveData()
    var num = 100
    var test1 = tast.getAbc()

    init{
        mUserLiveData.postValue(User(1,"name1"))
    }

    fun doSomething(){
        var user = mUserLiveData.value
        user?.age = user?.age?.plus(1) ?: -1
        user?.name = "name${user?.age}"
        mUserLiveData.value = user
    }
}
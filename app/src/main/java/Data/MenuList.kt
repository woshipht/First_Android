package Data

object MenuList {
    private val menuList = mutableListOf<MenuItemInfo>()

    fun addMenuList(menuItem: MenuItemInfo){
        menuList.add(menuItem)
    }

    fun getMenuList(): MutableList<MenuItemInfo> {
        return menuList
    }
}
package net.testusuke.thealloutwar

/**
 * Created by testusuke on 2022/05/08
 * @author testusuke
 */
object Message {

    //  permission error
    const val PERMISSION_ERROR = "§c権限がありません。"

    //  incorrect usage
    const val INCORRECT_COMMAND_USAGE = "§c構文が不正です。ヘルプを参照してください。"

    //  something wrong while using a database
    const val DATABASE_ERROR = "§cデータベース操作時に、なんらかの問題が発生しました。"

    /////////////////////
    //  Kit
    const val KIT_ALREADY_EXISTED = "§cすでにKitが登録されています。"
    const val KIT_NOT_EXISTED = "§cKitが登録されていません。"
    const val KIT_SUCCESS_CREATING = "§aKitを登録しました。name: #0"
    const val KIT_SUCCESS_DELETING = "§aKitを削除しました。"
    const val KIT_SUCCESS_UPDATING = "§aKitを削除しました。"
}
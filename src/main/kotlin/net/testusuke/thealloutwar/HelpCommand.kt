package net.testusuke.thealloutwar

import org.bukkit.entity.Player

/**
 * Created by testusuke on 2022/04/29
 * @author testusuke
 */
object HelpCommand {

    fun help(player: Player) {
        val msg = """
            §d================================
            §e/war help -> ヘルプ表示
            §aユーザーコマンド
            §e/war play register [team] -> ゲーム参加登録
            §e/war play unregister -> ゲーム参加取り消し
            §cアドミンコマンド
            §aGameコマンド
            §e/war
            §aMapコマンド
            §e/war map create <name> -> 指定した名前のMapを作成
            §e/war map delete <name> -> マップの削除
            §e/war map rename <old> <new> -> マップのリネーム
            §e/war map board <name> -> 指定したマップのダッシュボード
            §aKitコマンド
            §e/war kit create <name> -> Kitを作成(所持しているアイテムがKitとして使われます)
            §e/war kit delete <name> -> Kitの削除
            §e/war kit update <name> -> Kitの更新
            §e/war
            §d================================
        """.trimIndent()
        player.sendMessage(msg)
    }
}
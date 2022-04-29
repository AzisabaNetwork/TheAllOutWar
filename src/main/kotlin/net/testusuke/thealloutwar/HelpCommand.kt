package net.testusuke.thealloutwar

import org.bukkit.entity.Player

/**
 * Created by testusuke on 2022/04/29
 * @author testusuke
 */
object HelpCommand {

    fun help(player: Player) {
        val msg = """
            §d§l================================
            §e§l/war help -> ヘルプ表示
            §a§lユーザーコマンド
            §e§l/war play register [team] -> ゲーム参加登録
            §e§l/war play unregister -> ゲーム参加取り消し
            §c§lアドミンコマンド
            §a§lGameコマンド
            §e§l/war
            §a§lMapコマンド
            §e§l/war map create <name> -> 指定した名前のMapを作成
            §e§l/war map delete <name> -> マップの削除
            §e§l/war map rename <old> <new> -> マップのリネーム
            §e§l/war map board <name> -> 指定したマップのダッシュボード
            §a§lKitコマンド
            §e§l/war kit create <name> -> Kitを作成(所持しているアイテムがKitとして使われます)
            §e§l/war kit delete <name> -> Kitの削除
            §e§l/war kit update <name> -> Kitの更新
            §e§l/war
            §e§l/war
            §e§l/war
            §e§l/war
            §d§l================================
        """.trimIndent()
        player.sendMessage(msg)
    }
}
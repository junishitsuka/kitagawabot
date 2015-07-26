// TODO: ファイルの保存
// TODO: 並列処理

import dispatch._
import scala.xml.{ NodeSeq, Elem }
import net.liftweb._
import common._
import util._

object KeikoScraping {
  def main(args: Array[String]) = {
    val h = new Http
    val req = url("https://www.google.co.jp/search?q=%E5%8C%97%E5%B7%9D%E6%99%AF%E5%AD%90&espv=2&biw=1130&bih=718&source=lnms&tbm=isch&sa=X&ved=0CAYQ_AUoAWoVChMI4-qas6b4xgIVQi-mCh2EHwFQ") >\ "EUC-JP" // >\ => dispatchの演算子（only set charset）
    val html: String = h(req as_str) // as_strは結果の受け取り方

    val elem: NodeSeq = Html5.parse(html) openOr NodeSeq.Empty
    // \は直下の要素, \\は間を飛ばして探索
    elem \\ "img" \\ "@src" foreach { img => println(img.text) }
  }
}

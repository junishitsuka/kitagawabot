import dispatch._
import scala.xml.{ NodeSeq, Elem }
import net.liftweb._
import common._
import util._
import scalax.io._

object Filename {
  def unapply(url: String): Option[String] = {
    url.split("/").reverse.toList.headOption
  }
}

object KeikoScraping {
  def main(args: Array[String]) = {
    val h = new Http
    val req = url("https://www.google.co.jp/search?q=%E5%8C%97%E5%B7%9D%E6%99%AF%E5%AD%90&espv=2&biw=1130&bih=718&source=lnms&tbm=isch&sa=X&ved=0CAYQ_AUoAWoVChMI4-qas6b4xgIVQi-mCh2EHwFQ") >\ "EUC-JP" // >\ => dispatchの演算子（only set charset）
    val html: String = h(req as_str) // as_strは結果の受け取り方

    val elem: NodeSeq = Html5.parse(html) openOr NodeSeq.Empty
    // \は直下の要素, \\は間を飛ばして探索
    // (elem \\ "img" \\ "@src").foreach { img => saveImage(img.text) }
    // (elem \\ "img" \\ "@src").par.foreach { img => saveImage(img.text) }
    (elem \\ "img" \\ "@src").par.foreach { img => saveURL(img.text) }
  }

  def saveImage(url: String) = {
    val data = Resource.fromURL(url).byteArray
    url match {
      case Filename(file) => Resource.fromFile(new java.io.File("data", file)).write(data)
      case _ => sys.error("not file")
    }
  }

  def saveURL(url: String) = {
    val file = new java.io.PrintWriter(new java.io.FileWriter("images/url_list", true))
    file.write(url + '\n')
    file.close()
  }
}

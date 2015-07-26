import dispatch._

object Hi {
  def main(args: Array[String]) = {
    val h = new Http
    val req = url("https://www.google.co.jp/search?q=%E5%8C%97%E5%B7%9D%E6%99%AF%E5%AD%90&espv=2&biw=1130&bih=718&source=lnms&tbm=isch&sa=X&ved=0CAYQ_AUoAWoVChMI4-qas6b4xgIVQi-mCh2EHwFQ")
    println(req)
  }
}

object Luhn {
  def main(args: Array[String]): Unit = {
    val list = List[String](
      "011980422478189X", //1
      "772143801013511X", //4
      "973736969204716X", //0
      "793081803472918X", //1
      "358286935182058X"  //2
    )
    list.foreach(i => {
      println(check_num(i))
    })
  }

  def check_num(num16_str: String): Int = {
    //偶数桁ならtrue
    var even_true = true
    //偶数桁の合計
    var even = 0
    //奇数桁の合計
    var odd = 0
    val length = num16_str.length
    if (length != 16) {
      throw new Exception("16桁ではありません")
    }
    // 最後のXのみ取り出さない
    (0 to length - 2).foreach(i => {
      // i = 0なら16桁目で偶数桁、i = 1 だったら15桁目で奇数桁
      val num = num16_str(i).asDigit
      //偶数桁処理
      if (i % 2 == 0) {
        val even_tmp_str = num * 2
        //2倍して2桁だったら、-10+1
        if (even_tmp_str > 9)
          even += even_tmp_str - 10 + 1
        else
          even += even_tmp_str
      }
      //奇数桁処理
      else {
        odd += num
      }
    })
    //合計のあまり
    val sum_div_over = (even + odd) % 10
    if (sum_div_over == 0)
      0
    else
      10 - sum_div_over
  }
}
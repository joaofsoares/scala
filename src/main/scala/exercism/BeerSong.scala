package exercism

object BeerSong:
  def recite(beers: Int, cnt: Int): String =
    var str: String = ""
    var tmpBeer: Int = beers
    var tmpCnt: Int = cnt

    while tmpCnt > 0 do
      str += s"${checkUnit(tmpBeer).capitalize} of beer on the wall, ${checkUnit(tmpBeer)} of beer." +
        s"\n${checkDown(tmpBeer).capitalize}, ${checkUnit(tmpBeer - 1)} of beer on the wall.\n"
      tmpBeer -= 1
      tmpCnt -= 1
      if tmpCnt > 0 then str += '\n'

    str

  private def checkDown(bottle: Int): String =
    bottle match
      case 0 => "Go to the store and buy some more"
      case 1 => "Take it down and pass it around"
      case _ => "Take one down and pass it around"

  private def checkUnit(bottle: Int): String =
    bottle match
      case -1 => "99 bottles"
      case 0  => "no more bottles"
      case 1  => "1 bottle"
      case _  => s"$bottle bottles"

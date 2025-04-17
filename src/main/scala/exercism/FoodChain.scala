package exercism

import scala.collection.immutable.SeqMap

object FoodChain:
  def recite(start: Int, end: Int): String =
    val str =
      for i <- start to end yield i match
        case 1 =>
          generateVerse("fly", SeqMap.empty[String, String])
        case 2 =>
          generateVerse("spider", SeqMap("spider" -> "fly"))
        case 3 =>
          generateVerse("bird", SeqMap("bird" -> "spider", "spider" -> "fly"))
        case 4 =>
          generateVerse("cat", SeqMap("cat" -> "bird", "bird" -> "spider", "spider" -> "fly"))
        case 5 =>
          generateVerse("dog", 
          SeqMap(
            "dog" -> "cat",
            "cat" -> "bird",
            "bird" -> "spider",
            "spider" -> "fly"
          ))
        case 6 =>
          generateVerse("goat", SeqMap(
            "goat" -> "dog",
            "dog" -> "cat",
            "cat" -> "bird",
            "bird" -> "spider",
            "spider" -> "fly"
          ))
        case 7 =>
          generateVerse("cow", SeqMap(
            "cow" -> "goat",
            "goat" -> "dog",
            "dog" -> "cat",
            "cat" -> "bird",
            "bird" -> "spider",
            "spider" -> "fly"
          ))
        case 8 =>
          generateVerse("horse", SeqMap.empty[String, String])
        case _ =>

    str.mkString

  private def generateVerse(
      str: String,
      previous: Map[String, String]
  ): String =
    swallow(str) + action(str) + regression(previous) + lastMessage(str)

  private def swallow(str: String): String =
    s"I know an old lady who swallowed a $str.\n"

  private def action(str: String): String =
    str match
      case "spider" => "It wriggled and jiggled and tickled inside her.\n"
      case "bird"   => "How absurd to swallow a bird!\n"
      case "cat"    => "Imagine that, to swallow a cat!\n"
      case "dog"    => "What a hog, to swallow a dog!\n"
      case "goat"   => "Just opened her throat and swallowed a goat!\n"
      case "cow"    => "I don't know how she swallowed a cow!\n"
      case _        => ""

  private def regression(previous: Map[String, String]): String =
    previous
      .map((k, v) =>
        v match
          case "spider" =>
            s"She swallowed the $k to catch the $v that wriggled and jiggled and tickled inside her.\n"
          case _ => s"She swallowed the $k to catch the $v.\n"
      )
      .mkString

  private def lastMessage(str: String): String =
    str match
      case "horse" => "She's dead, of course!\n\n"
      case _ =>
        s"I don't know why she swallowed the fly. Perhaps she'll die.\n\n"

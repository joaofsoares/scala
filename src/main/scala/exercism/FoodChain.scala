package exercism

import scala.collection.immutable.SeqMap

object FoodChain:
  def recite(start: Int, end: Int): String =
    val str =
      for i <- start to end yield i match
        case 1 =>
          Chain("fly", "fly", SeqMap.empty[String, String]).generateVerse
        case 2 =>
          Chain("spider", "fly", SeqMap("spider" -> "fly")).generateVerse
        case 3 =>
          Chain(
            "bird",
            "fly",
            SeqMap("bird" -> "spider", "spider" -> "fly")
          ).generateVerse
        case 4 =>
          Chain(
            "cat",
            "fly",
            SeqMap("cat" -> "bird", "bird" -> "spider", "spider" -> "fly")
          ).generateVerse
        case 5 =>
          Chain(
            "dog",
            "fly",
            SeqMap(
              "dog" -> "cat",
              "cat" -> "bird",
              "bird" -> "spider",
              "spider" -> "fly"
            )
          ).generateVerse
        case 6 =>
          Chain(
            "goat",
            "fly",
            SeqMap(
              "goat" -> "dog",
              "dog" -> "cat",
              "cat" -> "bird",
              "bird" -> "spider",
              "spider" -> "fly"
            )
          ).generateVerse
        case 7 =>
          Chain(
            "cow",
            "fly",
            SeqMap(
              "cow" -> "goat",
              "goat" -> "dog",
              "dog" -> "cat",
              "cat" -> "bird",
              "bird" -> "spider",
              "spider" -> "fly"
            )
          ).generateVerse
        case 8 =>
          Chain("horse", "fly", SeqMap.empty[String, String]).generateVerse
        case _ =>

    str.mkString

class Chain(str: String, first: String, previous: Map[String, String]):
  private def swallow: String = s"I know an old lady who swallowed a $str.\n"

  private def action: String =
    str match
      case "spider" => "It wriggled and jiggled and tickled inside her.\n"
      case "bird"   => "How absurd to swallow a bird!\n"
      case "cat"    => "Imagine that, to swallow a cat!\n"
      case "dog"    => "What a hog, to swallow a dog!\n"
      case "goat"   => "Just opened her throat and swallowed a goat!\n"
      case "cow"    => "I don't know how she swallowed a cow!\n"
      case _        => ""

  private def lastMessage: String =
    str match
      case "horse" => "She's dead, of course!\n\n"
      case _ =>
        s"I don't know why she swallowed the $first. Perhaps she'll die.\n\n"

  private def regression: String =
    previous
      .map((k, v) =>
        v match
          case "spider" =>
            s"She swallowed the $k to catch the $v that wriggled and jiggled and tickled inside her.\n"
          case _ => s"She swallowed the $k to catch the $v.\n"
      )
      .mkString

  def generateVerse: String =
    swallow + action + regression + lastMessage

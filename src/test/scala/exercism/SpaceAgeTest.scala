package exercism

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.should

class SpaceAgeTest extends AnyFlatSpec {

  it should "matches age on earth" in {
    SpaceAge.onEarth(1_000_000_000) should be(31.69 +- 0.01)
  }

  it should "matches age on mercury" in {
    SpaceAge.onMercury(2_134_835_688) should be(280.88 +- 0.01)
  }

  it should "matches age on venus" in {
    SpaceAge.onVenus(189_839_836) should be(9.78 +- 0.01)
  }

  it should "matches age on mars" in {
    SpaceAge.onMars(2.329871239e9) should be(39.25 +- 0.01)
  }

  it should "matches age on jupiter" in {
    SpaceAge.onJupiter(901_876_382) should be(2.41 +- 0.01)
  }

  it should "matches age on saturn" in {
    SpaceAge.onSaturn(3.0e9) should be(3.23 +- 0.01)
  }

  it should "matches age on uranus" in {
    SpaceAge.onUranus(3.210123456e9) should be(1.21 +- 0.01)
  }

  it should "matches age on neptune" in {
    SpaceAge.onNeptune(8.210123456e9) should be(1.58 +- 0.01)
  }

}

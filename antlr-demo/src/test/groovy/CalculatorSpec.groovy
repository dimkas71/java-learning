import demo.CalculatorException
import demo.CalculatorImpl
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll


class CalculatorSpec extends Specification {

    @Unroll
    def "evaluating expressions. Result of expression ( #expression ) = #result"() {
        expect:
            def calc = new CalculatorImpl()
            calc.evaluate(expression) == result
        where:
            expression                      || result
            "1"                             || 1
            "1 + 2"                         || 3
            "1 + 2 * 3"                     || 7
            "(1 + 2) * 3 - 4"               || 5
            "1 + 2 * 3 - 4 * (12 - 3 * 3)"  || -5

    }

    def "if non correct expression then CalculatorException should be thrown"() {
        when:
            def calc = new CalculatorImpl()
            calc.evaluate("3 + d")
        then:
            def e = thrown(CalculatorException)
    }

}
package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항1의 첫번째 입니다.")
    void requirement1(){
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
    }

    @Test
    @DisplayName("요구사항1의 두번째 입니다.")
    void requirement11_1(){
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 입니다.")
    void requirement2(){
        String actual = "(1,2)";
        String result = actual.substring(1,actual.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 입니다.")
    void requirement3(){
        String actual = "abc";
        Character first  = actual.charAt(0);
        Character second  = actual.charAt(1);
        Character third  = actual.charAt(2);

        assertThat(first).isEqualTo('a');
        assertThat(second).isEqualTo('b');
        assertThat(third).isEqualTo('c');

        assertThatThrownBy(() -> {
            actual.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("String index out of range: 3");

    }

}

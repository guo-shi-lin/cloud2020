import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/8/10 9:48
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private String name;
    private String address;

    public static void main(String[] args) {
        Test test1 = new Test();
        Test test = new Test("1","2");
        System.out.println(test);
    }
}

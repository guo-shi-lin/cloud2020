import lombok.Data;

import java.lang.reflect.Field;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/7/20 10:15
 * @description：测试
 * @modified By：
 * @version: 1.0
 */
@Data
public class Test {
    @Mytest(name = "123")
    private static String name;

    public static void main(String[] args) {

        String name = null;
        try {
            Class<?> clzss = Class.forName("Test");
            Field[] fields = clzss.getDeclaredFields();
            for (Field field:fields) {
                Mytest mytest = field.getAnnotation(Mytest.class);
                if (mytest != null) {
                    field.setAccessible(true);
                }
                System.out.println(mytest.name());
                System.out.println(mytest.type());
            }

            Field field = clzss.getDeclaredField("name");
            System.out.println(field.getAnnotation(Mytest.class).name());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

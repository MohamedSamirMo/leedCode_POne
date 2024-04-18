import java.util.Stack;

public class Main {
//    يتم استيراد الفئة Stack من حزمة java.util لاستخدامها في تخزين الأرقام والعلامات.
//    تعريف الدالة calculate التي تأخذ تعبيرًا رياضيًا كنص وتُعيد قيمته المقدرة كعدد صحيح.
//    تعريف المتغيرات:
//    stack: مكدس لتخزين الأرقام الوسيطة والعلامات.
//            num: المتغير الحالي لبناء الأرقام.
//    sign: العلامة الحالية للعمليات الحسابية (+1 أو -1).
//    result: النتيجة النهائية للتعبير.
//    يتم تمرير النص حرفًا حرفًا باستخدام حلقة for-each.
//    يتم فحص كل حرف في التعبير:
//    إذا كان الحرف يمثل رقمًا، يتم بناء الرقم الحالي num عن طريق تحويل الحرف إلى رقم وإضافته إلى num.
//    إذا كان الحرف يمثل إشارة (+ أو -)، يتم إضافة الرقم الحالي إلى النتيجة result مع التعويض بالعلامة الحالية sign. ثم يتم إعادة ضبط num إلى الصفر وتعيين sign بناءً على الإشارة الجديدة.
//    إذا كان الحرف يمثل بداية قوس، يتم حفظ النتيجة الحالية والعلامة الحالية في المكدس وإعادة ضبط النتيجة والعلامة.
//    إذا كان الحرف يمثل نهاية قوس، يتم إضافة الرقم الحالي إلى النتيجة مع التعويض بالعلامة الحالية. ثم يتم ضرب النتيجة في العلامة السابقة وإضافة النتيجة السابقة المخزنة في المكدس.
//    الحرف ليس رقمًا أو إشارة، يتم تجاهله.
//    في النهاية، يتم إضافة الرقم الحالي إلى النتيجة مع التعويض بالعلامة الحالية، ويتم إرجاع النتيجة النهائية.

    public static void main(String[] args) {
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";

        System.out.println("Result for s1: " + Calculate(s1)); // Output: 2
        System.out.println("Result for s2: " + Calculate(s2)); // Output: 3
        System.out.println("Result for s3: " + Calculate(s3)); // Output: 23

}
public static int Calculate(String s){

    Stack<Integer> stack =new Stack<>();
    int num=0;
    int sign=1;
    int result=0;
    for (char c:s.toCharArray()){
        if (c == '+' || c == '-') {
            result += sign * num;
            num = 0;
            sign = (c == '+') ? 1 : -1;
        } else if (c == '(') {
            stack.push(result);
            stack.push(sign);
            result = 0;
            sign = 1;
        } else if (c == ')') {
            result += sign * num;
            num = 0;
            result *= stack.pop();
            result += stack.pop();
        } else if (Character.isDigit(c)) {
            num = num * 10 + (c - '0');
        }
    }

    result += sign * num;
    return result;
}
    }




package ShallowDeep;

public class CopyTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 建立測試資料
        Address address = new Address("中正路", "台北市");
        Contact contact = new Contact("0912345678", "test@example.com");
        
        // 測試淺拷貝
        System.out.println("===== 測試淺拷貝 =====");
        PersonShallowCopy original = new PersonShallowCopy("Tom", 25, address, contact);
        PersonShallowCopy shallowCopy = (PersonShallowCopy) original.clone();
        
        System.out.println("原始物件: " + original);
        System.out.println("淺拷貝物件: " + shallowCopy);
        
        // 修改參考型別的值
        shallowCopy.getAddress().setStreet("新生路");
        System.out.println("\n修改後：");
        System.out.println("原始物件: " + original);
        System.out.println("淺拷貝物件: " + shallowCopy);
        
        // 測試深拷貝
        System.out.println("\n===== 測試深拷貝 =====");
        PersonDeepCopy originalDeep = new PersonDeepCopy("Jerry", 30, address, contact);
        PersonDeepCopy deepCopy = (PersonDeepCopy) originalDeep.clone();
        
        System.out.println("原始物件: " + originalDeep);
        System.out.println("深拷貝物件: " + deepCopy);
        
        // 修改參考型別的值
        deepCopy.getAddress().setStreet("復興路");
        System.out.println("\n修改後：");
        System.out.println("原始物件: " + originalDeep);
        System.out.println("深拷貝物件: " + deepCopy);
    }
}


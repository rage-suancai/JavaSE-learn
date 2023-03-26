package javaSE.javaseIntermediate.javase8;

/**
 * 泛型与多态
 * 泛型不仅仅可以定义在类上 同时也能定义在接口上:
 *                  public interface ScoreInterface<T> {
 *                      T getScore();
 *                      void setScore(T t);
 *                  }
 *
 * 当实现此接口时 我们可以选择在实现类明确泛型类型或是继续使用此泛型 让具体创建的对象来确定类型
 *                  public class Score<T> implements ScoreInterface<T> { // 将Score转换为泛型类<T>
 *
 *                      private final String name;
 *                      private final String id;
 *                      private T score;
 *
 *                      public Score(String name, String id, T score) {
 *                          this.name = name;
 *                          this.id = id;
 *                          this.score = score;
 *                      }
 *
 *                      public T getScore() {
 *                          return score;
 *                      }
 *
 *                      @Override
 *                      public void setScore(T score) {
 *                          this.score = score;
 *                      }
 *
 *                  }
 *
 *                  public class StringScore implements ScoreInterface<String> { // 在实现时明确类型
 *
 *                      @Override
 *                      public String getScore(){
 *                          return null;
 *                      }
 *
 *                      @Override
 *                      public void setScore(String s){
 *
 *                      }
 *
 *                  }
 *
 * 抽象类同理 再来就不多做演示了
 *
 * 多态类型擦除
 * 思考一个问题 既然继承后明确了泛型类型 那么为什么@Override不会出现错误呢 重写的条件是需要和父类的返回值类型 形式 参数一致
 * 而泛型默认的原始类型是Object类型 子类明确后变为Number类型 这显然不满足重写的条件 但是为什么依然能编译通过呢?
 *                  class A<T> {
 *                      private T t;
 *                      public T get(){
 *                          return t;
 *                      }
 *                      public void set(T t){
 *                          this.t = t;
 *                      }
 *                  }
 *
 *                  class B extends A<Number> {
 *                      private Number n;
 *
 *                      @Override
 *                      public Number get(){ // 这并不满足重写的要求 因为只能重写父类同样返回值和参数的方法 但是这样却能够通过编译
 *                          return t;
 *                      }
 *
 *                      @Override
 *                      public void set(){
 *                          this.t = t;
 *                      }
 *
 *                  }
 *
 * 通过反编译进行观察 实际上是编译器帮助我们生成了两个桥接方法用于支持重写:
 *                  @Override
 *                  public Object get(){
 *                      return this.get(); // 调用返回Number的那个方法
 *                  }
 *
 *                  @OVerride
 *                  public void set(Object t){
 *                      this.set((Number) t); // 调用参数是Number的那个方法
 *                  }
 */
public class Main {

    public static void main(String[] args) {



    }

}

package velazquez._5_spring_security_jpa.mappers;

public interface Mapper<A, B> {

  B mapTo(A a);

  A mapFrom(B b);
}

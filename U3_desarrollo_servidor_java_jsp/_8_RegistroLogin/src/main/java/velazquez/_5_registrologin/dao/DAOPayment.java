package velazquez._5_registrologin.dao;

import velazquez._5_registrologin.model.Payment;

import java.util.List;

public interface DAOPayment {

  public List<Payment> getAllPayments();

  public Payment getPayment(int customerNumber, String checkNumber);

  public boolean removePayment(int customerNumber, String checkNumber);

  public boolean updatePayment(Payment payment);

  public boolean insertPayment(Payment payment);
}

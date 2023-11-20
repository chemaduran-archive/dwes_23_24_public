package velazquez._3_jstl_editarclientes.dao;

import java.util.List;

import velazquez._3_jstl_editarclientes.model.PaymentBean;

public interface DAOPayment {

  public List<PaymentBean> getAllPayments();

  public PaymentBean getPayment(int customerNumber, String checkNumber);

  public boolean removePayment(int customerNumber, String checkNumber);

  public boolean updatePayment(PaymentBean payment);
}

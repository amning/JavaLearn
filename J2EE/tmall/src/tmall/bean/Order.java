package tmall.bean;

import jdk.net.SocketFlow;
import tmall.dao.OrderDao;

import java.util.Date;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/13.
 */
public class Order {
    private List<OrderItem> orderItems;//一个订单包括多个订单项
    private float total;//订单总价格
    private int totalNumber;//订单商品数量
    private int id;
    private String orderCode;//订单号
    private String address;//地址
    private String post;//邮寄方式
    private String mobile;//电话
    private String receiver;//收件人
    private String userMessage;//客户留言
    private Date payDate;//付款时间
    private Date creatDate;//创建时间
    private Date deliverDate;//发货时间
    private Date confirmDate;//订单确认时间
    private User user;
    private String status;//订单状态

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    /*
    在数据库中存放的Status是英文，而在界面上需要把这些英文对应的中文显示出来
     */
    public String setStatus(String status) {
        String desc="未知";
        //          case OrderDAO.waitPay:
//              desc="待付款";
//              break;
//          case OrderDAO.waitDelivery:
//              desc="待发货";
//              break;
//          case OrderDAO.waitConfirm:
//              desc="待收货";
//              break;
//          case OrderDAO.waitReview:
//              desc="等评价";
//              break;
//          case OrderDAO.finish:
//              desc="完成";
//              break;
//          case OrderDAO.delete:
//              desc="刪除";
//              break;
//          default:
//              desc="未知";

        return desc;
    }
}

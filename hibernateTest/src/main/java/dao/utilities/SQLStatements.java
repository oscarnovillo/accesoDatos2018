/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utilities;

/**
 *
 * @author Laura
 */
public class SQLStatements {

    public static final String SELECT_all_customers = "select * from Customers";
    public static final String SELECT_all_items = "select * from Items";
    public static final String SELECT_all_purchases = "select * from Purchases";
    public static final String SELECT_all_reviews = "select * from Reviews";

    public static final String INSERT_customer = "insert into Customers (name, telephone, address, idUser) values(?, ?, ?, ?)";
    public static final String INSERT_item = "insert into Items (name, company, price) values(?, ?, ?)";
    public static final String INSERT_review = "insert into Reviews (rating, title, description, date, idPurchase) values(?, ?, ?, ?,?)";
    public static final String INSERT_purchase = "insert into Purchases (date, idCustomer, idItem) values(?, ?, ?)";
    public static final String INSERT_user = "insert into Users (username, pass, type) values(?, ?, ?)";


    public static final String DELETE_customer = "delete from Customers where idCustomer = ?";
    public static final String DELETE_item = "delete from Items where idItem = ?";
    public static final String DELETE_review = "delete from Reviews where idReview = ?";
    public static final String DELETE_purchase = "delete from Purchases where idPurchase = ?";

    public static final String UPDATE_customer = "update Customers set name = ?,telephone =?, address=? where idCustomer = ?";
    public static final String UPDATE_item = "update Items set name = ?,company =?, price=? where idItem = ?";
    public static final String UPDATE_review = "update Reviews set rating = ?,title =?, description=? where idReview = ?";

    public static final String SELECT_item_ByID = "select * from Items where idItem = ?";
    public static final String SELECT_customer_ByID = "select * from Customers where idCustomer = ?";

    public static final String SELECT_purchase_ByDate = "select * from Purchases where date = ?";
    public static final String SELECT_purchase_ByCustomerId = "select * from Purchases where idCustomer = ?";
    public static final String SELECT_purchase_ById = "select * from Purchases where idPurchase = ?";
    public static final String SELECT_purchases_ByItemId = "select idPurchase from Purchases where idItem= ?";

    public static final String SELECT_reviews_ByItem = "select * from Reviews where idPurchase in (select idPurchase from Purchases where idItem = ?)";
    public static final String SELECT_reviews_ByCustomer = "select * from Reviews where idPurchase in (select idPurchase from Purchases where idCustomer = ?)";
    public static final String SELECT_reviews_ByPurchase = "select * from Reviews where idPurchase = ?";

    public static final String DELETE_reviews_byCustomer = "delete from Reviews where idPurchase in (select idPurchase from Purchases where idCustomer = ?)";
    public static final String DELETE_purchases_byCustomer = "delete from Purchases where idCustomer = ?";
    public static final String DELETE_user_byId = "delete from Users where idUser = ?";
    
    public static final String SELECT_user_byName = "select * from Users where username = ?";
    public static final String SELECT_customer_byidUser = "select * from Customers where idUser = ?";

}

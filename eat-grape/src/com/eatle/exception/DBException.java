/**
 */
package com.eatle.exception;

/**
 * @Title: 数据访问异常
 * @Description:
 * @Author:xt
 * @Since:2012-6-18
 * @Version:1.1.0
 */
public class DBException extends RuntimeException {

     /**
     * 
     */
     public DBException() {
          super();
     }

     /**
      * @param message
      * @param cause
      */
     public DBException(String message, Throwable cause) {
          super(message, cause);
     }

     /**
      * @param message
      */
     public DBException(String message) {
          super(message);
     }

     /**
      * @param cause
      */
     public DBException(Throwable cause) {
          super(cause);
          // TODO Auto-generated constructor stub
     }

     private static final long serialVersionUID = 3137325332494188646L;

}

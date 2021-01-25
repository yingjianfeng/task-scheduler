package springbootapi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Title: Response
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/22 11:04
 */
@Data
@AllArgsConstructor
public class Response implements Serializable {
    String result;
}

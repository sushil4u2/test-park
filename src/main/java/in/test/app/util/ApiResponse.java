package in.test.app.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.slf4j.MDC;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "result",
    "status",
    "traceId"
})
public class ApiResponse<T> {

  @JsonProperty("result")
  private T result;
  @JsonProperty("status")
  private Integer status;

  public ApiResponse() {
  }

  public ApiResponse(T result, Integer status) {
    this.result = result;
    this.status = status;
  }

  @JsonProperty("result")
  public T getResult() {
    return result;
  }

  @JsonProperty("result")
  public void setResult(T result) {
    this.result = result;
  }

  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(Integer status) {
    this.status = status;
  }

}

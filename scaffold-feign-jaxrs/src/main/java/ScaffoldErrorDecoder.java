import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ScaffoldErrorDecoder extends ErrorDecoder.Default {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            if (response.body() != null) {
                BaseResult result = objectMapper.readValue(response.body().asReader(), BaseResult.class);

                int status = response.status();
                if (status >= 500) {
                    throw new BusinessException();
                } else if (status == 403) {
                    throw new AuthorizationException();
                } else if (status >= 400) {
                    throw new BusinessException();
                }
            }
        } catch (Exception e) {

        }

        return super.decode(methodKey, response);
    }
}

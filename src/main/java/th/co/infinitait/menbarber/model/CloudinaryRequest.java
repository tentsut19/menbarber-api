package th.co.infinitait.menbarber.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryRequest {

    private Long documentNumber;
    private String fileName;
    private String type;
    private String description;

}

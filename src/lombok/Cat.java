package lombok;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Cat {
    @Getter
    private String name;
    @NonNull
    private int age;
}

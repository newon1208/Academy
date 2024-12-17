package vn.techzen.academy_pnv.dto.page;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageCustom<T> {
    int currentPage;
    int totalPages;
    int pageSize;
    long totalElements;

    @Builder.Default
    List<T> data = Collections.emptyList();

    // Phương thức hỗ trợ lấy trạng thái trang hiện tại
    public boolean isFirstPage() {
        return currentPage == 0;
    }

    public boolean isLastPage() {
        return currentPage + 1 == totalPages;
    }

    public boolean hasNextPage() {
        return currentPage + 1 < totalPages;
    }

    public boolean hasPreviousPage() {
        return currentPage > 0;
    }

    // Phương thức tạo một trang rỗng
    public static <T> PageCustom<T> empty(int pageSize) {
        return PageCustom.<T>builder()
                .currentPage(0)
                .totalPages(0)
                .pageSize(pageSize)
                .totalElements(0)
                .data(Collections.emptyList())
                .build();
    }
}

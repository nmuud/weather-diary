package zero.weather_app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zero.weather_app.domain.Diary;
import zero.weather_app.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Operation(
            summary = "일기 작성",
            description = "특정 날짜와 함께 일기 텍스트를 입력받아 저장합니다.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "저장할 일기 내용",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "오늘은 맑았습니다."))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "일기 저장 성공")
            }
    )
    @PostMapping("/create/diary")
    void createDiary(
            @Parameter(description = "일기가 저장될 날짜 (yyyy-MM-dd 형식)", example = "2024-12-01")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text
    ) {
        diaryService.createDiary(date, text);
    }

    @Operation(
            summary = "일기 조회",
            description = "특정 날짜에 저장된 일기를 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "일기 조회 성공")
            }
    )
    @GetMapping("/read/diary")
    List<Diary> readDiary(
            @Parameter(description = "조회할 날짜 (yyyy-MM-dd 형식)", example = "2024-12-01")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return diaryService.readDiary(date);
    }

    @Operation(
            summary = "기간별 일기 조회",
            description = "시작 날짜와 종료 날짜를 입력받아 해당 기간의 모든 일기 데이터를 반환합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "일기 조회 성공")
            }
    )
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
            @Parameter(description = "조회할 기간의 첫 번째 날 (yyyy-MM-dd 형식)", example = "2024-12-01")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,

            @Parameter(description = "조회할 기간의 마지막 날 (yyyy-MM-dd 형식)", example = "2024-12-02")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return diaryService.redDiaries(startDate, endDate);
    }

    @Operation(
            summary = "일기 수정",
            description = "기존에 저장된 특정 날짜의 일기 내용을 수정합니다.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "수정할 일기 내용",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "string", example = "오늘은 흐렸습니다.")
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "일기 수정 성공")
            }
    )
    @PutMapping("/update/diary")
    void updateDiary(
            @Parameter(description = "수정할 날짜 (yyyy-MM-dd 형식)", example = "2024-12-01")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text
    ) {
        diaryService.updateDiary(date, text);
    }

    @Operation(
            summary = "일기 삭제",
            description = "특정 날짜에 저장된 일기를 삭제합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "일기 삭제 성공")
            }
    )
    @DeleteMapping("/delete/diary")
    void deleteDiary(
            @Parameter(description = "삭제할 날짜 (yyyy-MM-dd 형식)", example = "2024-12-01")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        diaryService.deleteDiary(date);
    }
}

//package preproject.back.Answer.controller;
//
//
//import com.google.gson.Gson;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import preproject.back.Answer.Entity.Answer;
//import preproject.back.Answer.dto.AnswerPatchDto;
//import preproject.back.Answer.dto.AnswerPostDto;
//import preproject.back.Answer.mapper.AnswerMapper;
//import preproject.back.Answer.service.AnswerService;
//import preproject.back.Member.dto.MemberResponseDto;
//import preproject.back.Member.mapper.MemberMapper;
//
//import javax.transaction.Transactional;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.Matchers.startsWith;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.mock;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@Transactional
//@WebMvcTest(AnswerController.class)
//@AutoConfigureMockMvc
//public class AnswerControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private Gson gson;
//
//    @MockBean
//    private AnswerService answerService;
//
//    @MockBean
//    private MemberMapper memberMapper;
//
//    @MockBean
//    private AnswerMapper mapper;
//
////Todo    @MockBean
////    private QuestionService questionService;
////
////    @MockBean
////    private QuestionMapper questionMapper;
//
////    @BeforeEach
////    private void init() {
////      MemberResponseDto memberResponse = //Todo memberResponseDto??????  ?????? ??? ????????? ??? ??? ??????
////                new MemberResponseDto(
////                        "stub_email@user.com",
////                        "Stub_name"
////                        );
//
////
////        given(memberMapper.memberToMemberResponseDto(Mockito.any())).willReturn(memberResponse);
////    }
//
//    @Test
//    void postAnswerTest() throws Exception{
//
//        //given request body ??????
//        AnswerPostDto post = new AnswerPostDto("????????? ??????","????????? ????????????");
//        long questionId = 1;
//
//        Answer answer = mapper.AnswerPostToAnswer(post);
//
//        answer.setAnswerId(1L);
//
//        //service ???????????? ??????(stub data ??????)
//        given(answerService.createAnswer(Mockito.any(Answer.class))).willReturn(answer);
//
//        String content = gson.toJson(post);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/questions/{question_id}/answers") //?????? ?????? ??? url ??????
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        //then
//        actions.andExpect(status().isCreated());
////                .andExpect(header().string("Location", is(startsWith("/answers"))));
//    }
//
//    @Test
//    void patchAnswerTest() throws Exception {
//
//        //given
//        AnswerPatchDto patch = new AnswerPatchDto(1L, "????????? ??????", "????????? ??????");
//
//        Answer answer = mapper.AnswerPatchToAnswer(patch);
//
//        long answerId = patch.getAnswerId();
//
//        given(answerService.updateAnswer(Mockito.anyLong(), Mockito.any(Answer.class))).willReturn(answer);
//
//        String content = gson.toJson(patch);
//
//        //when
//
//        ResultActions actions = mockMvc.perform(
//                patch("/answers/{answer_Id}", answerId)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        //then
//                actions
//                        .andExpect(status().isOk())
//                        .andExpect(jsonPath("$.data.title").value(patch.getTitle()));
////                        .andExpect(jsonPath("$."))
//        // (6)
//
//    }
//
//    @Test
//    void getAnswerTest() throws Exception {
//
//        //given
//        Answer answer1 = new Answer(1L, "????????????", "????????????");
//        Answer answer2 = new Answer(2L, "????????????2", "????????????2");
//        Answer answer3 = new Answer(3L, "????????????3", "????????????3");
//
//        int page = 1;
//        int size = 10;
//
//        List<Answer> answers = Arrays.asList(answer1, answer2, answer3);
//
//        // List<Answer> answers = new Answer[answer1, answer2, answer3]();
//
//        Page<Answer> pageAnswer = new PageImpl<>(List.of(answer1, answer2, answer3),
//                PageRequest.of(page - 1, size, Sort.by("answerId").descending()), 3);
//
//        given(answerService.findAnswers(page - 1, size)).willReturn(pageAnswer);
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                get("/answers?page={page}&size={size}", page, size));
//
//        //then
//        MvcResult result = actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isArray())
//                .andExpect(jsonPath("$.data.length()").value(3))
//                .andReturn();
//
//        System.out.println(result.getResponse().getContentAsString());
//
//    }
//
//    @Test
//    void deleteAnswerTest() throws Exception{
//
//        //given
//        Answer answer = new Answer(1L, "????????????", "????????????");
//        long answerId = answer.getAnswerId();
//
//        //when.then
//        mockMvc.perform(delete("/answer/{answer_id}",answerId))
//                .andExpect(status().isNoContent())
//                .andReturn();
//
//
//    }
//
//}

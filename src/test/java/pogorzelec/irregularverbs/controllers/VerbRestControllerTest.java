package pogorzelec.irregularverbs.controllers;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pogorzelec.irregularverbs.model.Verb;
import pogorzelec.irregularverbs.persistence.database.VerbDatabaseService;

import java.util.Collection;


@RunWith(SpringRunner.class)
@WebMvcTest(VerbRestController.class)
public class VerbRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VerbDatabaseService verbDatabaseService;

    @Test
    public void testGetAll() throws Exception {

        Verb testVerb = new Verb("do", "did", "done");
        Collection<Verb> testVerbs = singletonList(testVerb);

        given(verbDatabaseService.getAll()).willReturn(testVerbs);

        mvc.perform(get("/api/verbs").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstForm", is(testVerb.getFirstForm())))
                .andExpect(jsonPath("$[0].secondForm", is(testVerb.getSecondForm())))
                .andExpect(jsonPath("$[0].thirdForm", is(testVerb.getThirdForm())));
    }
}

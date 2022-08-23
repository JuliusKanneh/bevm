package com.wisdom.bevm.controllers;

import com.wisdom.bevm.exceptions.PollingCenterNotFoundException;
import com.wisdom.bevm.exceptions.VoteNotFoundException;
import com.wisdom.bevm.models.Citizen;
import com.wisdom.bevm.models.Votes;
import com.wisdom.bevm.services.CandidateService;
import com.wisdom.bevm.services.CitizenService;
import com.wisdom.bevm.services.PollingCenterService;
import com.wisdom.bevm.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class VotingController {

    @Autowired
    private VoteService voteService;

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private PollingCenterService pollingCenterService;

    @GetMapping("/votes")
    public String homePage(Model model){
        List<Votes> votes = voteService.findAll();
        model.addAttribute("votes", votes);
        return "vote";
    }

    @GetMapping("/votes/add")
    public String showForm(Votes vote, Model model){
        model.addAttribute("vote", vote);
        model.addAttribute("citizens", citizenService.findAll());
        model.addAttribute("candidates", candidateService.findAll());
        model.addAttribute("pollingCenters", pollingCenterService.findAll());
        return "vote_form";
    }

    @PostMapping("/votes")
    public String save(Votes vote, RedirectAttributes redirectAttributes) throws IOException {
        boolean isUpdating;
        boolean isVoterUnique = true;
        boolean isCandidateUnique = true;

        Long voterNid = vote.getVoterNid();
        Long candidateId = vote.getCandidateId();

        System.out.println("Voter NID: " + voterNid);
        System.out.println("Candidate ID: " + candidateId);

        if(voterNid == null || candidateId == null){
            redirectAttributes.addFlashAttribute("message", "Voter NID nor Candidate ID must not be null");
            return "redirect:/polling-centers";
        }

        if (!voteService.isVoterUnique(voterNid) && vote.getVoterNid() != null){
            redirectAttributes.addFlashAttribute("message",
                    "Supervisor with NID " +vote.getVoterNid()+ " Already Exist!");
            isVoterUnique = false;
        }

        if (!voteService.isCandidateUnique(candidateId) && vote.getCandidateId() != null){
            redirectAttributes.addFlashAttribute("message",
                    "Candidate with ID " +vote.getCandidateId()+ " Already Exist!");
            isCandidateUnique = false;
        }

        if(vote.getId() != null){
            //TODO Consider doing this a better way later
            Long _voterNid = voteService.findById(vote.getVoterNid()).get().getVoterNid();
            Long _candidateId = voteService.findById(vote.getCandidateId()).get().getVoterNid();

            if (vote.getVoterNid() != _voterNid){
                if (!isVoterUnique){
                    return "redirect:/votes";
                }
            }
            if (vote.getCandidateId() != _candidateId){
                if (!isCandidateUnique){
                    return "redirect:/votes";
                }
            }
            isUpdating = true;
        }else {
            if (!isVoterUnique){
                return "redirect:/votes";
            }
            isUpdating = false;
        }

        vote.setDateVoted(new Date());
        Votes savedVote = voteService.add(vote);

        if(isUpdating){
            redirectAttributes.addFlashAttribute("message", "Vote ID " +vote.getId()+ " has been updated successfully!");
        }else {
            redirectAttributes.addFlashAttribute("message", "The Vote has been saved successfully!");
        }

        return "redirect:/votes";
    }

    @GetMapping("/votes/edit/{id}")
    public String showEditAndDetailsForm(@PathVariable("id") Long id, Model model){
        Optional<Votes> vote = voteService.findById(id);
        if (vote.isPresent()){
            Votes _vote = vote.get();
            model.addAttribute("vote", _vote);
            model.addAttribute("citizens", citizenService.findAll());
            model.addAttribute("candidates", candidateService.findAll());
            model.addAttribute("pollingCenters", pollingCenterService.findAll());
        }else {
            model.addAttribute("message", "No Record found with Vote ID " + id);
        }

        return "vote_form";
    }

    @GetMapping("/votes/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            voteService.delete(id);
            redirectAttributes.addFlashAttribute("message", "The Vote Id " + id + " has been deleted!");
        } catch (VoteNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/votes";
    }

    @GetMapping("/votes/candidates")
    public String showCandidates(){
        return "voting_candidates";
    }

    @PostMapping("/votes/find-citizen")
    public String findCitizenByNid(@RequestParam("nid") Long nid, Model model){
        System.out.println("NID: " + nid);
        Optional<Citizen> found  = citizenService.findById(nid);
        if (found.isPresent()){
            Citizen _found = found.get();
            System.out.println("Citizen ID: " + _found.getNid());
            System.out.println("FingerPrint ID: " + _found.getFingerPrintId());
            model.addAttribute("foundCitizen", _found);
        }

        return "index";
    }

    @PostMapping("/votes/print/find-citizen")
    public String findCitizenByFingerPrintId(@RequestParam("f_id") Integer f_id, Model model){
        System.out.println("Fingerprint ID: " + f_id);
        Citizen found  = citizenService.findByFingerPrintId(f_id);
        System.out.println("Citizen ID: " + found.getNid());
        System.out.println("FingerPrint ID: " + found.getNid());

        model.addAttribute("foundCitizen", found);
        return "redirect:/votes/candidates";
    }
}

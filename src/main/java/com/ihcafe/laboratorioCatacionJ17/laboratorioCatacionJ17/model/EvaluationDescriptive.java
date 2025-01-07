package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblEvaluationDescriptive")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class EvaluationDescriptive {

    @Id
    @Column(name = "descriptive_id")
    private String affectiveId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cupping_id")
    private Cupping cupping;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fragance_id")
    private FraganceDescriptive fraganceDescriptive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scent_id")
    private ScentDescriptive scentDescriptive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flavor_id")
    private FlavorDescriptive flavorDescriptive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "afterTaste_id")
    private AfterTasteDescriptive afterTasteDescriptive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acidity_id")
    private AcidityDescriptive acidityDescriptive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sweetNess_id")
    private SweetNessDescriptive sweetNessDescriptive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voice_id")
    private VoiceDescriptive voiceDescriptive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "general_id")
    private GeneralDescriptive generalDescriptive;

}

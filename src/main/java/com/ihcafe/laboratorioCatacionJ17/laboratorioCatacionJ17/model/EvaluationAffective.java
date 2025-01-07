package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblEvaluationAffective")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class EvaluationAffective {

    @Id
    @Column(name = "Affective_id")
    private String affectiveId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cupping_id")
    private Cupping cupping;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fragance_id")
    private FraganceAffective fraganceAffective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scent_id")
    private ScentAffective scentAffective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flavor_id")
    private FlavorAffective flavorAffective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "afterTaste_id")
    private AfterTasteAffective afterTasteAffective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acidity_id")
    private AcidityAffective acidityAffective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sweetNess_id")
    private SweetNessAffective sweetNessAffective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voice_id")
    private VoiceAffective voiceAffective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "general_id")
    private GeneralAffective generalAffective;

}

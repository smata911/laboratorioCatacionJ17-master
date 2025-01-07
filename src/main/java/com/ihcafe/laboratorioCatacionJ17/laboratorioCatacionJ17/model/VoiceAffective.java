package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tblVoiceAffective")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VoiceAffective {

    @Id
    @Column(name = "voice_id",nullable = false,length = 65)
    private String voiceId;

    @Column(name = "voice_name",nullable = false,length = 50)
    private int voiceName;


}

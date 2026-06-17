package com.projeto.ecommerce.domain.entity;

import com.projeto.ecommerce.domain.enums.StatusDoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Size(min = 8, message = "Senha deve conter no minimo 8 caracteres")
    @Column(nullable = false, length = 255)
    private String senha;

    @Pattern(regexp = "^\\\\+?[1-9]\\\\d{1,14}$")
    @Column(length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDoUsuario status = StatusDoUsuario.ATIVO;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataDeCriacao;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime dataDeAtualizacao;
}

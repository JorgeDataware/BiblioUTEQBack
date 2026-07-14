package com.scrip.msprestamos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservas", schema = "operaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(name = "libro_id", nullable = false)
    private UUID libroId;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estado = EstadoReserva.ACTIVA;

    @Builder.Default
    @Column(name = "fecha_reserva", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT now()")
    private OffsetDateTime fechaReserva = OffsetDateTime.now();

    @Column(name = "fecha_expiracion", nullable = false)
    private OffsetDateTime fechaExpiracion;
}


package com.scrip.msprestamos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "prestamos", schema = "operaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prestamo {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(name = "libro_id", nullable = false)
    private UUID libroId;

    @Column(name = "reserva_id")
    private UUID reservaId; // Opcional, puede ser null si el préstamo no proviene de una reserva

    @Builder.Default
    @Column(name = "fecha_prestamo", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT now()")
    private OffsetDateTime fechaPrestamo = OffsetDateTime.now();

    @Column(name = "fecha_limite", nullable = false)
    private OffsetDateTime fechaLimite;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPrestamo estado = EstadoPrestamo.ACTIVO;
}
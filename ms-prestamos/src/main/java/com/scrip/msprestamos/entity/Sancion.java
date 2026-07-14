package com.scrip.msprestamos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "sanciones", schema = "operaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sancion {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(name = "prestamo_id", nullable = false)
    private UUID prestamoId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSancion estado = EstadoSancion.PENDIENTE;

    @Builder.Default
    @Column(name = "fecha_generacion", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT now()")
    private OffsetDateTime fechaGeneracion = OffsetDateTime.now();

    @Column(name = "fecha_pago")
    private OffsetDateTime fechaPago; // Puede ser null hasta que la sanción sea pagada
}
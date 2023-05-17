package com.example.demo.domain;

import com.example.demo.domain.a.*;
import com.example.demo.domain.b.*;
import com.example.demo.domain.c.CEntity;
import com.example.demo.domain.c.CRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class TestService {
    @Autowired
    private ARepository aRepository;
    @Autowired
    private AConverter aConverter;

    @Autowired
    private BRepository bRepository;
    @Autowired
    private BConverter bConverter;

    @Autowired
    private CRepository cRepository;

    public AEntity createOne() {

        final SortedSet<BRelation> bList = new TreeSet<>();

        for (int i = 0; i < 2; i++) {
            final SortedSet<CRelation> cList = new TreeSet<>();
            for (int j = 0; j < 3; j++) {
                final CEntity cEntity = new CEntity();
                cRepository.save(cEntity);
                final CRelation cRel = new CRelation();
                cRel.setTarget(cEntity);
                cRel.setOrder(j);
                cList.add(cRel);
            }

            final BEntity bEntity = BEntity.builder()
                    .crelation(cList)
                    .build();
            bRepository.save(bEntity);
            final BRelation bRel = new BRelation();
            bRel.setTarget(bEntity);
            bRel.setOrder(i);
            bList.add(bRel);
        }

        final AEntity aEntity = AEntity.builder()
                .brelations(bList)
                .build();
        return aRepository.save(aEntity);
    }

    public Optional<AEntity> getOneAById(final Long id) {
        return aRepository.findOneById(id)
            .map(proj -> aConverter.convert(proj));
    }

    public Optional<BEntity> getOneBById(final Long id) {
        return bRepository.findOneById(id)
            .map(proj -> bConverter.convert(proj));
    }
}

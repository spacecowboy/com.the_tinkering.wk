package com.the_tinkering.wk.model

import com.the_tinkering.wk.db.model.Subject
import com.the_tinkering.wk.enums.LessonOrder
import com.the_tinkering.wk.enums.SubjectType
import kotlin.random.Random

fun getBalancedOrder(
    subjects: List<Subject>,
    order: LessonOrder,
    prioritizeRadicals: Boolean
): List<Subject> {
    val radicals = subjects.filter { it.type == SubjectType.WANIKANI_RADICAL }.toMutableList()
    val kanji = subjects.filter { it.type == SubjectType.WANIKANI_KANJI }.toMutableList()
    val vocab = subjects.filter { it.type == SubjectType.WANIKANI_VOCAB }.toMutableList()

    return sequence {
        while (prioritizeRadicals && radicals.isNotEmpty()) {
            yield(radicals.removeAt(0))
        }

        while (radicals.isNotEmpty() || kanji.isNotEmpty() || vocab.isNotEmpty()) {
            val choice = when (order) {
                LessonOrder.BALANCED_BY_FREQUENCY -> randomByFrequency(radicals, kanji, vocab)
                else -> randomByType(radicals, kanji, vocab)
            }
            when (choice) {
                SubjectType.WANIKANI_RADICAL -> yield(radicals.removeAt(0))
                SubjectType.WANIKANI_KANJI -> yield(kanji.removeAt(0))
                SubjectType.WANIKANI_VOCAB -> yield(vocab.removeAt(0))
            }
        }
    }.toList()
}

private fun randomByType(
    radicals: List<Subject>,
    kanji: List<Subject>,
    vocab: List<Subject>
): SubjectType {
    val possibilities = listOfNotNull(
        if (radicals.isNotEmpty()) SubjectType.WANIKANI_RADICAL else null,
        if (kanji.isNotEmpty()) SubjectType.WANIKANI_KANJI else null,
        if (vocab.isNotEmpty()) SubjectType.WANIKANI_VOCAB else null
    )

    return possibilities[Random.nextInt(possibilities.size)]
}

private fun randomByFrequency(
    radicals: List<Subject>,
    kanji: List<Subject>,
    vocab: List<Subject>
): SubjectType {
    val totalSize = radicals.size + kanji.size + vocab.size
    val randomIndex = Random.nextInt(totalSize)

    return when {
        randomIndex >= radicals.size + kanji.size -> SubjectType.WANIKANI_VOCAB
        randomIndex >= radicals.size -> SubjectType.WANIKANI_KANJI
        else -> SubjectType.WANIKANI_RADICAL
    }
}
